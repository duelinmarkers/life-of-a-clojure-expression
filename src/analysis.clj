(ns analysis
  (:require a-map clojure.inspector [clojure.tools.analyzer.jvm :as ana]))

(defn -main []
  (clojure.inspector/inspect-tree (ana/analyze-ns 'a-map))
  )

(comment

  (ana/analyze' '(defn m [v] {:foo "bar" :baz v}))

  {:op :def :children [:meta :init]
   :var #'analysis/m
   :name m
   :init {:op :fn :children [:methods]
          :methods [{:op :fn-method :children [:params :body]
                     :arglist [v]
                     :params [{:op :binding
                               :name v__#0
                               :o-tag java.lang.Object
                               :variadic? false
                               :arg-id 0
                               :tag java.lang.Object
                               :local :arg
                               :form v
                               :env {:once false :context :ctx/expr :locals {} :ns analysis :file "/tmp/form-init603147821765432124.clj"}}]
                     :body {:op :do :children [:statements :ret]
                            :statements []
                            :ret {:op :map :children [:keys :vals]
                                  :keys [{:tag clojure.lang.Keyword :o-tag clojure.lang.Keyword :op :const :env {:once false :context :ctx/expr :locals {v {:form v :name v :variadic? false :op :binding :arg-id 0 :local :arg}} :ns analysis :loop-id loop_9175 :loop-locals 1 :file "/tmp/form-init603147821765432124.clj"} :type :keyword :literal? true :val :foo :form :foo}
                                     {:tag clojure.lang.Keyword :o-tag clojure.lang.Keyword :op :const :env {:once false :context :ctx/expr :locals {v {:form v :name v :variadic? false :op :binding :arg-id 0 :local :arg}} :ns analysis :loop-id loop_9175 :loop-locals 1 :file "/tmp/form-init603147821765432124.clj"} :type :keyword :literal? true :val :baz :form :baz}]
                                  :vals [{:op :const
                                          :type :string
                                          :val "bar"
                                          :literal? true
                                          :tag java.lang.String :o-tag java.lang.String
                                          :form "bar"
                                          :env {:once false :context :ctx/expr :locals {v {:form v :name v :variadic? false :op :binding :arg-id 0 :local :arg}} :ns analysis :loop-id loop_9175 :loop-locals 1 :file "/tmp/form-init603147821765432124.clj"}}
                                         {:op :local :children []
                                          :name v__#0
                                          :variadic? false
                                          :arg-id 0
                                          :tag java.lang.Object :o-tag java.lang.Object
                                          :local :arg
                                          :assignable? false
                                          :form v
                                          :env {:once false
                                                :context :ctx/expr
                                                :locals {v {:form v
                                                            :name v
                                                            :variadic? false
                                                            :op :binding
                                                            :arg-id 0
                                                            :local :arg}}
                                                :ns analysis
                                                :loop-id loop_9175
                                                :loop-locals 1
                                                :file "/tmp/form-init603147821765432124.clj"}}]
                                  :tag clojure.lang.PersistentArrayMap :o-tag clojure.lang.PersistentArrayMap
                                  :env {:once false :context :ctx/return :locals {v {:form v :name v :variadic? false :op :binding :arg-id 0 :local :arg}} :ns analysis :loop-id loop_9175 :loop-locals 1 :file "/tmp/form-init603147821765432124.clj"}
                                  :form {:foo "bar" :baz v}}
                            :tag clojure.lang.PersistentArrayMap :o-tag clojure.lang.PersistentArrayMap
                            :body? true
                            :env {:once false :context :ctx/return :locals {v {:form v :name v :variadic? false :op :binding :arg-id 0 :local :arg}} :ns analysis :loop-id loop_9175 :loop-locals 1 :file "/tmp/form-init603147821765432124.clj"}
                            :form (do {:foo "bar" :baz v})}
                     :fixed-arity 1
                     :loop-id loop_9175
                     :env {:once false :context :ctx/expr :locals {} :ns analysis :file "/tmp/form-init603147821765432124.clj"}
                     :variadic? false
                     :form ([v] {:foo "bar" :baz v})
                     :tag java.lang.Object :o-tag java.lang.Object}]
          :return-tag clojure.lang.PersistentArrayMap
          :env {:context :ctx/expr :locals {} :ns analysis :file "/tmp/form-init603147821765432124.clj"}
          :variadic? false
          :once false
          :max-fixed-arity 1
          :form (fn* ([v] {:foo "bar" :baz v}))
          :tag clojure.lang.AFunction :o-tag clojure.lang.AFunction
          :arglists ([v])
          :raw-forms ((clojure.core/fn ([v] {:foo "bar" :baz v})))}
   :meta {:op :const
          :val {:arglists ([v]) :column 16 :line 1 :file "/tmp/form-init603147821765432124.clj"}
          :tag clojure.lang.PersistentArrayMap :o-tag clojure.lang.PersistentArrayMap
          :literal? true
          :type :map
          :env {:context :ctx/expr :locals {} :ns analysis :file "/tmp/form-init603147821765432124.clj"}
          :form {:file "/tmp/form-init603147821765432124.clj" :line 1 :column 16 :arglists (quote ([v]))}}
   :return-tag clojure.lang.PersistentArrayMap
   :env {:context :ctx/expr :locals {} :ns analysis :column 16 :line 1 :file "/tmp/form-init603147821765432124.clj"}
   :top-level true
   :form (def m (clojure.core/fn ([v] {:foo "bar" :baz v})))
   :tag clojure.lang.Var :o-tag clojure.lang.Var
   :arglists ([v])
   :raw-forms ((defn m [v] {:foo "bar" :baz v}))}

  (ana/analyze' '(+ 2.2 (max 23 24)))

  {:op :static-call :children [:args]
   :class clojure.lang.Numbers
   :method add
   :args [{:op :const
           :type :number
           :val 2.2
           :literal? true
           :tag double :o-tag double
           :env {:context :ctx/expr :locals {} :ns analysis :file "/tmp/form-init603147821765432124.clj"}
           :form 2.2}
          {:op :static-call
           :class clojure.lang.Numbers
           :method max
           :children [:args]
           :args [{:op :const
                   :type :number
                   :val 23
                   :literal? true
                   :tag long :o-tag long
                   :env {:context :ctx/expr :locals {} :ns analysis :file "/tmp/form-init603147821765432124.clj"}
                   :form 23}
                  {:op :const
                   :type :number
                   :val 24
                   :literal? true
                   :tag long :o-tag long
                   :env {:context :ctx/expr :locals {} :ns analysis :file "/tmp/form-init603147821765432124.clj"}
                   :form 24}]
           :env {:context :ctx/expr :locals {} :ns analysis :column 23 :line 1 :file "/tmp/form-init603147821765432124.clj"}
           :form (. clojure.lang.Numbers (max 23 24))
           :tag long :o-tag long
           :validated? true
           :raw-forms ((max 23 24))}]
   :env {:context :ctx/expr :locals {} :ns analysis :column 16 :line 1 :file "/tmp/form-init603147821765432124.clj"}
   :top-level true
   :form (. clojure.lang.Numbers (add 2.2 (max 23 24)))
   :tag double :o-tag double
   :validated? true
   :raw-forms ((+ 2.2 (max 23 24)))}
  )
