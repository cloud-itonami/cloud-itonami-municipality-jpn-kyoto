(ns ordinance.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest kyoto-has-spec-basis
  (let [sb (facts/spec-basis "kyoto")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://www.city.kyoto.lg.jp/") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "uji")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["kyoto" "uji"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["uji"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["kyoto.akiya-katsuyo-tekisei-kanri-jorei-2013"]
         (mapv :ordinance/id (facts/by-topic "kyoto" :housing))))
  (is (empty? (facts/by-topic "kyoto" :labor)))
  (is (empty? (facts/by-topic "uji" :transparency))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/datascript-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
