(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojurescript "1.9.293"]
                 [adzerk/boot-cljs "1.7.228-2"]
                 [pandeiro/boot-http "0.7.3"]
                 [reagent "0.6.0"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]])

(deftask brepl
  []
  (with-pass-thru _
    ))
