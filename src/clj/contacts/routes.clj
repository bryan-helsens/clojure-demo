(ns contacts.routes
   (:require [schema.core :as s]
            [contacts.contacts :refer [get-contacts
                                       create-contact
                                       get-contact-by-id
                                       update-contact
                                       delete-contact]]))

(def ping-routes
  ["/ping" {:get (fn [req]
                     {:status 200
                      :body {:ping "pong"}})}])

(def contact-routes
  ["/contacts"
   ["" {:get get-contacts
        :post {:parameters {:body {:first_name s/Str
                                   :last_name s/Str
                                   :email s/Str}}
               :handler create-contact}}]
    ["/:id" {:parameters {:path {:id s/Int}}
             :get get-contact-by-id
             :put {:parameters {:body {:first_name s/Str
                                       :last_name s/Str
                                       :email s/Str}}
                   :handler update-contact}
             :delete delete-contact}]])
