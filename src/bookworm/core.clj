(ns bookworm.core)

(defn books [& fltr]
  (let [book-dir "/Users/Thoughtworker/Dropbox/Books"]
    (->> book-dir
         clojure.java.io/file
         file-seq
         (filter #(.isFile %))
         (filter #(re-find #"^.*\.(pdf|PDF)$" (.getName %)))
         (map (fn [file] [(.getPath file) (.getName file)]))
         (into {}))))
