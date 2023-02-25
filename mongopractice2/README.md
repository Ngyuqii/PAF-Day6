### To query a document database (MongoDB)
- Import a Json document (tv-shows.json) into a new MongoDB database - database shows, collection tv.
- List out the types of tv shows on index page.
- Retrieve all tv shows under the selected type, and display list of shows in descending order of ratings, with corresponding show URL as hyperlink (Get /tvshow/type/{type}). Include show rating in view.
- Retrieve all tv shows that meet language criteria - default English, and display with corresponding show URL as hyperlink (Get /tvshow or /tvshow?lang=English).