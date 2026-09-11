# cloud-itonami-municipality-jpn-kyoto

Municipal-ordinance compliance catalog for **Kyoto** (京都市) —
a Wave 1b addition per ADR-2607171400 addendum 2, joining the
`cloud-itonami-municipality-*` compliance-fact family of ADR-2607141700
(`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`;
see e.g.
[`cloud-itonami-municipality-jpn-tokyo`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-tokyo),
[`cloud-itonami-municipality-jpn-osaka`](https://github.com/cloud-itonami/cloud-itonami-municipality-jpn-osaka)
and
[`cloud-itonami-municipality-ita-roma`](https://github.com/cloud-itonami/cloud-itonami-municipality-ita-roma)).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the City of Kyoto's
behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljk` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries were verified on 2026-07-17 against official
city.kyoto.lg.jp sources: the **京都市清酒の普及の促進に関する条例**
(the "乾杯条例"; 平成25年1月1日京都市条例第32号, 平成25年1月15日施行 —
official page and its ordinance PDF read directly; the 条例番号 line was
additionally read verbatim from a 判例地方自治 related-topics PDF, since
the official page prints the 施行日 but not the number) and the
**京都市空家等の活用、適正管理等に関する条例** (平成25年12月24日条例第80号,
最終改正 令和5年12月13日条例第30号 — verified by directly reading the
official PDF's title header).

## Culture catalog

Alongside the ordinance catalog, this repo carries a **regional-culture
catalog** (ADR-2607171400, `cloud-itonami-municipality-culture-catalog`
in `com-junkawasaki/root`) — local dishes, festivals, crafts and heritage
sites for Kyoto:

- `src/culture/facts.cljk` — the catalog, source of truth.
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

Same provenance discipline as the ordinance catalog: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Ordinance text
itself remains the City of Kyoto's; this repo stores only citation
metadata (id/title/url/dates), not full text.
