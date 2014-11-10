(ns a-map)

(defn m [v] {:foo "bar" :baz v})

(def a-const {:foo "bar" :baz 23})

(defn a-const-fn [] {:foo "bar" :baz 24})

(defn m-big [v]
  {:a 1 :b 2 :c 3 :d 4 :e 5 :f 6 :g 7 :h 8 :i v})

(defn calls-m [] (m "my val"))
