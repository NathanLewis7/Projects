//This is server.java

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 8080), 0);

        server.createContext("/", new HomeHandler());
	server.createContext("/movies", new MoviesHandler());
	server.createContext("/shows", new ShowsHandler());
	server.createContext("/profile", new ProfileHandler());	

        server.setExecutor(null);
        server.start();

        System.out.println("Server running on http://localhost:8080");
    }
static class HomeHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {

        String html = """
        <html>
        <head>
        <style>
        body { background: #141414; color: white; font-family: Arial; }
        a { color: red; margin-right: 20px; }
        .title { font-size: 40px; padding: 20px; }
        </style>
        </head>
        <body>

        <div class="title">My Netflix Clone</div>

        <a href="/">Home</a>
        <a href="/movies">Movies</a>
        <a href="/shows">Shows</a>
        <a href="/profile">Profile</a>

        <h2>Welcome to the self-hosted streaming UI</h2>

        </body>
        </html>
        """;

        send(exchange, html);
    }
}



static class MoviesHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {

        String html = """
        <html>
        <head>
        <style>
        body { background:#141414; color:white; font-family:Arial; }
        a { color:red; margin-right:15px; text-decoration:none; }
        .nav { padding:10px; }

        .grid {
            display:flex;
            gap:20px;
            padding:20px;
        }

        .card {
            background:#222;
            padding:10px;
            width:150px;
            border-radius:8px;
            text-align:center;
        }

        img {
            width:100%;
            border-radius:5px;
        }
        </style>
        </head>

        <body>

        <div class="nav">
            <a href="/">Home</a>
            <a href="/movies">Movies</a>
            <a href="/shows">Shows</a>
            <a href="/profile">Profile</a>
        </div>

        <h1>Movies</h1>

        <div class="grid">

	<div class="card">
    		<img src="https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg">
    		<p>The Dark Knight</p>
	</div>

	<div class="card">
    		<img src="https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg">
    		<p>Interstellar</p>
	</div>

	<div class="card">
    		<img src="https://m.media-amazon.com/images/I/41kTVLeW1CL._AC_.jpg">
    		<p>Avatar</p>
	</div>


        </div>

        </body>
        </html>
        """;

        send(exchange, html);
    }
}


static class ShowsHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {

        String html = """
        <html>
        <head>
        <style>
        body {
            background:#141414;
            color:white;
            font-family:Arial;
        }

        a {
            color:red;
            margin-right:15px;
            text-decoration:none;
        }

        .nav {
            padding:15px;
        }

        .grid {
            display:flex;
            gap:20px;
            padding:20px;
            justify-content:center;
        }

        .card {
            background:#222;
            padding:10px;
            width:160px;
            border-radius:8px;
            text-align:center;
        }

        .card img {
            width:100%;
            border-radius:5px;
        }

        .card:hover {
            background:#333;
        }

        </style>
        </head>

        <body>

        <!-- NAV BAR -->
        <div class="nav">
            <a href="/">Home</a>
            <a href="/movies">Movies</a>
            <a href="/shows">Shows</a>
            <a href="/profile">Profile</a>
        </div>

        <h1>TV Shows</h1>

        <div class="grid">

            <div class="card">
                <img src="https://upload.wikimedia.org/wikipedia/en/d/d6/Friends_season_one_cast.jpg">
                <p>Friends</p>
            </div>

            <div class="card">
                <img src="https://image.tmdb.org/t/p/w500/ztkUQFLlC19CCMYHW9o1zWhJRNq.jpg">
                <p>Breaking Bad</p>
            </div>

            <div class="card">
		<img src="https://upload.wikimedia.org/wikipedia/en/d/d8/Game_of_Thrones_title_card.jpg">
                <p>Game of Thrones</p>
            </div>

        </div>

        </body>
        </html>
        """;

        send(exchange, html);
    }
}



static class ProfileHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {

        String html = """
        <html>
        <head>
        <style>
        body {
            background:#141414;
            color:white;
            font-family:Arial;
            text-align:center;
        }

        a {
            color:red;
            margin-right:15px;
            text-decoration:none;
        }

        .nav {
            padding:15px;
        }

        .profiles {
            display:flex;
            justify-content:center;
            gap:30px;
            margin-top:60px;
        }

        .profile {
            background:#222;
            padding:20px;
            border-radius:10px;
            width:150px;
            cursor:pointer;
            transition: 0.2s;
        }

        .profile:hover {
            background:#444;
            transform: scale(1.05);
        }

        .profile img {
            width:100px;
            height:100px;
            border-radius:50%;
            margin-bottom:10px;
        }

        </style>
        </head>

        <body>

        <!-- NAV BAR -->
        <div class="nav">
            <a href="/">Home</a>
            <a href="/movies">Movies</a>
            <a href="/shows">Shows</a>
            <a href="/profile">Profile</a>
        </div>

        <h1>Who is watching?</h1>

        <div class="profiles">

            <div class="profile">
                <img src="https://i.pravatar.cc/100?img=1">
                <p>John Marks</p>
            </div>

            <div class="profile">
                <img src="https://i.pravatar.cc/100?img=2">
                <p>Jordan Lee</p>
            </div>

            <div class="profile">
                <img src="https://i.pravatar.cc/100?img=3">
                <p>Nathan Lewis</p>
            </div>

            <div class="profile">
                <img src="https://i.pravatar.cc/100?img=4">
                <p>Kurt Campbell</p>
            </div>

        </div>

        </body>
        </html>
        """;

        send(exchange, html);
    }
}


static void send(HttpExchange exchange, String response) throws IOException {
    exchange.sendResponseHeaders(200, response.getBytes().length);
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
}

}

