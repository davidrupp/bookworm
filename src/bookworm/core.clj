(ns bookworm.core)

(defn books 
  ([] (books ""))
  ([fltr]
      (let [book-dir "/Users/Thoughtworker/Dropbox/Books"
            book-regex (re-pattern (str "(?i)^.*" (str fltr) ".*\\.(pdf|PDF)$"))]
        (->> book-dir
             clojure.java.io/file
             file-seq
             (filter #(.isFile %))
             (filter #(re-find book-regex (.getName %)))
             (map (juxt #(.getPath %) #(.getName %)))
             (into {})))))

(defn find-books
  ([] (find-books ""))
  ([fltr] (clojure.pprint/pprint (sort (keys (books (str fltr)))))))
