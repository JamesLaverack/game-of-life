(ns gol.core-test
  (:require [clojure.test :refer :all]
            [clojure.core.matrix :as matrix]
            [gol.core :refer :all]))

(deftest test-seed
  (let [width 100
        height 50
        world (seed width height)]
    (testing "world created in the correct size"
      (is (= height (matrix/row-count world)))
      (is (= width (matrix/column-count world))))))
