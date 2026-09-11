(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest kyoto-has-culture-basis
  (let [sb (facts/spec-basis "kyoto")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "kyoto" (:culture/municipality %)) sb))
    (is (every? #(= "JPN" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "uji")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["kyoto" "uji"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["uji"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "kyoto" :dish))))
  (is (= ["kyoto.craft.nishijin-ori"]
         (mapv :culture/id (facts/by-kind "kyoto" :craft))))
  (is (= 2 (count (facts/by-kind "kyoto" :festival))))
  (is (empty? (facts/by-kind "kyoto" :beverage)))
  (is (empty? (facts/by-kind "uji" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
