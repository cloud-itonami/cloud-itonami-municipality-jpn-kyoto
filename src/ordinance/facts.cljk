(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Kyoto (京都市) -- a Wave 1b
  addition per ADR-2607171400 addendum 2, joining the
  cloud-itonami-municipality-* compliance-fact family of ADR-2607141700
  (cloud-itonami-compliance-fact-federation; see
  cloud-itonami-municipality-jpn-tokyo and -jpn-osaka for the Japanese
  siblings).

  Every entry cites an OFFICIAL city.kyoto.lg.jp URL -- never fabricated.
  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/number.

  Both entries below were verified on 2026-07-17. The sake-promotion
  ordinance ('乾杯条例'): its official page states 平成25年1月15日施行,
  and the official PDF linked from it (seisyujourei.pdf) was downloaded
  and read via the Read tool (full text, 4 articles + 附則); its
  公布年月日番号 line (平成25年1月1日京都市条例第32号) was additionally
  read verbatim from a 判例地方自治 related-topics PDF
  (horei.lawsquare.jp), because the official page/PDF print the 施行日
  but not the 条例番号. The vacant-houses ordinance was verified by
  downloading the official PDF and reading its header verbatim via the
  Read tool: 平成25年12月24日条例第80号, 改正 平成27年12月22日条例第25号
  / 平成30年6月11日条例第12号 / 令和5年12月13日条例第30号.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"kyoto"
   [{:ordinance/id "kyoto.seishu-fukyu-sokushin-jorei-2013"
     :ordinance/title "京都市清酒の普及の促進に関する条例 (Kyoto City Ordinance on the Promotion of Sake)"
     :ordinance/municipality "kyoto"
     :ordinance/country "JPN"
     :ordinance/kind :ordinance
     :ordinance/number "平成25年1月1日京都市条例第32号（平成25年1月15日施行）"
     :ordinance/url "https://www.city.kyoto.lg.jp/sankan/page/0000150907.html"
     :ordinance/url-provenance :official-city-kyoto-lg-jp
     :ordinance/enacted-date "2013-01-01"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:traditional-industry :culture}}
    {:ordinance/id "kyoto.akiya-katsuyo-tekisei-kanri-jorei-2013"
     :ordinance/title "京都市空家等の活用、適正管理等に関する条例 (Kyoto City Ordinance on the Utilization and Proper Management of Vacant Houses)"
     :ordinance/municipality "kyoto"
     :ordinance/country "JPN"
     :ordinance/kind :ordinance
     :ordinance/number "平成25年12月24日条例第80号"
     :ordinance/url "https://www.city.kyoto.lg.jp/tokei/cmsfiles/contents/0000155/155468/jorei%28R051213%29.pdf"
     :ordinance/url-provenance :official-city-kyoto-lg-jp
     :ordinance/enacted-date "2013-12-24"
     :ordinance/last-revised-date "2023-12-13"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:housing :urban-planning}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-jpn-kyoto Wave 1b (ADR-2607171400 "
                 "addendum 2 / family ADR-2607141700): "
                 (count (get catalog "kyoto")) " Kyoto entries seeded with "
                 "official city.kyoto.lg.jp citations. Extend "
                 "`ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
