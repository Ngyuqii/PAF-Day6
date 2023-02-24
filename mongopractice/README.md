### To query a document database (MongoDB)
- Import a Json document (tv-shows.json) into a new MongoDB database - database shows, collection tv.
(mongoimport "mongodb://localhost:27017" -d shows -c tv --jsonArray --file tv-shows.json)
- Retrieve all tv shows that meet language criteria - default English, and display with corresponding show URL as hyperlink (Get /tvshow or /tvshow?lang=English).