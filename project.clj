(defproject gol "0.1.0-SNAPSHOT"
  :description "Game of Life"
  :url "https://github.com/JamesLaverack/gol"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot gol.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
