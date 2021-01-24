(ns contacts.db
  (:require [hugsql.core :as hugsql]))


(def config 
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "//192.168.199.220/clj_contacts"
   :user "postgres"
   :password "postgres"})

(hugsql/def-db-fns "contacts.sql")

(comment 
  (create-contacts-table config)
  (get-contacts config)
  (get-contact-by-id config {:id 1})
  (insert-contact config {:first_name "Albert"
                          :last_name "Verhoeve"
                          :email "a.verhoeve@hotmail.com"})
  (delete-contact-by-id config {:id 1}))

