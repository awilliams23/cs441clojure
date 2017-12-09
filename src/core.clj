(ns game.core
	(:gen-class)
	(:use [clojure.string :only (split)]))

(use 'clojure.java.io)




;Function provided by: http://codingdojang.com/scode/411
(defn maximize [coins]
  (if (empty? coins)
    0
    (let [left-first  (+ (first coins)
                         (min (maximize (rest (rest coins)))
                              (maximize (butlast (rest coins)))))
          right-first (+ (last coins)
                         (min (maximize (rest (butlast coins)))
                              (maximize (butlast (butlast coins)))))]
      (max left-first right-first))))
                         

(defn -main 
	[]
	(println "What's the name of your text file? Include .txt extension.")
	(let [input (split (slurp (str "src/files/"(read-line))) #"\s+")]
		(let [fixinput (map #(Integer/parseInt %) (drop 1 input))]
			(let [player1tot (maximize fixinput)]
				(println (str "Player 1: " player1tot))
				(time(maximize fixinput))
				(let [player2tot (- (reduce + fixinput) player1tot)]
					(println (str "Player 2: " player2tot))
					(time(- (reduce + fixinput) player1tot))))))

	
	


		;(let [player1tot (maximize (map #(Integer/parseInt %) (drop 1 input)))]
		;	(println player1tot)
		;	(let [player2tot (maximize (- (maximize (map #(Integer/parseInt %) input)) player1tot))]
		;		(println player2tot))))

			;(let [player2tot (maximize (- (map #(Integer/parseInt %) input) player1tot))])))




				
				
)

