(ns culture.facts
  "Regional-culture catalog for Kyoto (京都市) -- local dishes, festivals,
  crafts and heritage sites, piggybacked onto this municipality compliance
  repo per ADR-2607171400 (cloud-itonami-municipality-culture-catalog, in
  com-junkawasaki/root), sibling namespace to `ordinance.facts`
  (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"kyoto"
   [{:culture/id "kyoto.dish.yudofu"
     :culture/name "Yudofu"
     :culture/name-local "湯豆腐"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :dish
     :culture/summary "Hot-pot dish of tofu gently heated in kombu-infused water, whose origin is attributed to the area around Nanzen-ji temple in Kyoto."
     :culture/url "https://ja.wikipedia.org/wiki/%E6%B9%AF%E8%B1%86%E8%85%90"
     :culture/url-provenance :wikipedia-ja
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kyoto.dish.yatsuhashi"
     :culture/name "Yatsuhashi"
     :culture/name-local "八ツ橋"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :dish
     :culture/summary "Confection of glutinous rice flour, sugar and cinnamon, one of Kyoto's best-known regional souvenirs, sold both baked and unbaked (nama yatsuhashi)."
     :culture/url "https://en.wikipedia.org/wiki/Yatsuhashi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kyoto.dish.kaiseki"
     :culture/name "Kaiseki"
     :culture/name-local "懐石"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :dish
     :culture/summary "Traditional multi-course Japanese dinner; Kyoto's kaiseki-style cooking is called kyō-ryōri (京料理), reflecting the city's long history as home of the imperial court."
     :culture/url "https://en.wikipedia.org/wiki/Kaiseki"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kyoto.dish.nishin-soba"
     :culture/name "Nishin soba"
     :culture/name-local "にしんそば"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :dish
     :culture/summary "Buckwheat noodles topped with sweetly braised dried herring; developed in Kyoto in 1882 and now a Kyoto specialty."
     :culture/url "https://ja.wikipedia.org/wiki/%E3%81%AB%E3%81%97%E3%82%93%E3%81%9D%E3%81%B0"
     :culture/url-provenance :wikipedia-ja
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kyoto.festival.gion-matsuri"
     :culture/name "Gion Matsuri"
     :culture/name-local "祇園祭"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :festival
     :culture/summary "One of Japan's largest festivals, held each July in Kyoto and centered on Yasaka Shrine; its yamaboko float processions of 17 and 24 July are inscribed on UNESCO's Representative List of the Intangible Cultural Heritage of Humanity (2009)."
     :culture/url "https://en.wikipedia.org/wiki/Gion_Matsuri"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kyoto.festival.gozan-no-okuribi"
     :culture/name "Gozan no Okuribi"
     :culture/name-local "五山送り火"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :festival
     :culture/summary "Culmination of the Obon season on 16 August, when five giant bonfires are lit on the mountains surrounding Kyoto."
     :culture/url "https://en.wikipedia.org/wiki/Gozan_no_Okuribi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kyoto.craft.nishijin-ori"
     :culture/name "Nishijin-ori"
     :culture/name-local "西陣織"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :craft
     :culture/summary "Traditional silk textiles produced in the Nishijin district of Kamigyō-ku, Kyoto, using specialized weaving techniques."
     :culture/url "https://en.wikipedia.org/wiki/Nishijin-ori"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kyoto.heritage.kiyomizu-dera"
     :culture/name "Kiyomizu-dera"
     :culture/name-local "清水寺"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :heritage
     :culture/summary "Buddhist temple founded in 778 in Higashiyama-ku, eastern Kyoto; part of the UNESCO World Heritage Site Historic Monuments of Ancient Kyoto (1994)."
     :culture/url "https://en.wikipedia.org/wiki/Kiyomizu-dera"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "kyoto.heritage.kinkaku-ji"
     :culture/name "Kinkaku-ji (Golden Pavilion)"
     :culture/name-local "金閣寺"
     :culture/municipality "kyoto"
     :culture/country "JPN"
     :culture/kind :heritage
     :culture/summary "Zen Buddhist temple in Kita-ku, Kyoto, whose pavilion's upper two floors are coated in gold leaf; a World Heritage-designated site, with the present pavilion rebuilt in 1955."
     :culture/url "https://en.wikipedia.org/wiki/Kinkaku-ji"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-jpn-kyoto culture catalog "
                 "(ADR-2607171400): " (count (get catalog "kyoto"))
                 " Kyoto entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
