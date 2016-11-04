(ns dk.salza.liq.keys)

;; http://ascii-table.com/ansi-escape-sequences.php
(defn raw2keyword
  [raw]
  (let [k (str (char raw))]
     (cond (re-matches #"[a-zA-Z0-9]" k) (keyword k)
           (= k "\t") :tab
           (= k " ") :space
           (= raw 13) :enter
           (= raw 33) :exclamation
           (= raw 34) :quote
           (= raw 35) :hash
           (= raw 36) :dollar
           (= raw 37) :percent
           (= raw 38) :ampersand
           (= raw 39) :singlequote
           (= raw 40) :parenstart
           (= raw 41) :parenend
           (= raw 42) :asterisk
           (= raw 43) :plus
           (= raw 44) :comma
           (= raw 45) :dash
           (= raw 46) :dot
           (= raw 47) :slash
           (= raw 58) :colon
           (= raw 59) :semicolon
           (= raw 60) :lt
           (= raw 61) :equal
           (= raw 62) :gt
           (= raw 63) :question
           (= raw 64) :at
           (= raw 91) :bracketstart
           (= raw 92) :backslash
           (= raw 93) :bracketend
           (= raw 94) :hat
           (= raw 95) :underscore
           (= raw 123) :bracesstart
           (= raw 124) :pipe
           (= raw 125) :bracesend
           (= raw 126) :tilde
           (= raw 164) :curren
           (= raw 197) :caa
           (= raw 198) :cae
           (= raw 216) :coe
           (= raw 229) :aa
           (= raw 230) :ae
           (= raw 248) :oe
           (= raw 6) :C-f
           (= raw 7) :C-g
           (= raw 10) :C-j
           (= raw 11) :C-k
           (= raw 12) :C-l
           (= raw 15) :C-o
           (= raw 17) :C-q
           (= raw 19) :C-s
           (= raw 20) :C-t
           (= raw 23) :C-w
           (= raw 0) :C-space
           (= raw 127) :backspace
           true :unknown)))

(defn alphanum-mapping
  [fun]
  (into {}
        (map (fn [x] [(keyword (str (char x)))
                      #(fun (str (char x)))])
             (concat (range 97 123) (range 65 91) (range 48 58)))))

(defn lower-mapping
  [fun]
  (into {}
        (map (fn [x] [(keyword (str (char x)))
                      #(fun (str (char x)))])
             (range 97 123))))

(defn symbols-mapping
  [fun]
  {:exclamation #(fun "!")
   :quote #(fun "\"")
   :hash #(fun "#")
   :dollar #(fun "$")
   :percent #(fun "%")
   :ampersand #(fun "&")
   :singlequote #(fun "'")
   :parenstart #(fun "(")
   :parenend #(fun ")")
   :asterisk #(fun "*")
   :plus #(fun "+")
   :comma #(fun ",")
   :dash #(fun "-")
   :dot #(fun ".")
   :slash #(fun "/")
   :colon #(fun ":")
   :semicolon #(fun ";")
   :lt #(fun "<")
   :equal #(fun "=")
   :gt #(fun ">")
   :question #(fun "?")
   :at #(fun "@")
   :bracketstart #(fun "[")
   :bracketend #(fun "]")
   :hat #(fun "^")
   :bracesstart #(fun "{")
   :underscore #(fun "_")
   :backslash #(fun "\\")
   :pipe #(fun "|")
   :bracesend #(fun "}")
   :tilde #(fun "~")
   :curren #(fun "¤")
   :caa #(fun "Å")
   :cae #(fun "Æ")
   :coe #(fun "Ø")
   :aa #(fun "å")
   :ae #(fun "æ")
   :oe #(fun "ø")})