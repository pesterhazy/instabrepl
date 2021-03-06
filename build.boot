(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojurescript "1.9.293"]
                 [adzerk/boot-cljs "1.7.228-2"]
                 [pandeiro/boot-http "0.7.3"]
                 [weasel "0.7.0" :exclusions [org.clojure/clojurescript]]
                 [reagent "0.6.0"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]])

(deftask brepl
  []
  (with-pass-thru _
    (require 'instabrepl.repl)
    ((resolve 'instabrepl.repl/run))))
