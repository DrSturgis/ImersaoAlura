package com.drsturgis.service;

import com.drsturgis.Config;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Top250Filmes {
    private Config config = new Config();
    private String body;
    public Top250Filmes() throws IOException, InterruptedException {

        String apiKey = config.props.getProperty("APIKEY");
        String url = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
        //System.out.println(url);
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        this.body = "{\"items\":[{\"id\":\"tt0111161\",\"rank\":\"1\",\"title\":\"The Shawshank Redemption\",\"fullTitle\":\"The Shawshank Redemption (1994)\",\"year\":\"1994\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg\",\"crew\":\"Frank Darabont (dir.), Tim Robbins, Morgan Freeman\",\"imDbRating\":\"9.2\",\"imDbRatingCount\":\"2611538\"},{\"id\":\"tt0068646\",\"rank\":\"2\",\"title\":\"The Godfather\",\"fullTitle\":\"The Godfather (1972)\",\"year\":\"1972\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_2.jpg\",\"crew\":\"Francis Ford Coppola (dir.), Marlon Brando, Al Pacino\",\"imDbRating\":\"9.2\",\"imDbRatingCount\":\"1807168\"},{\"id\":\"tt0468569\",\"rank\":\"3\",\"title\":\"The Dark Knight\",\"fullTitle\":\"The Dark Knight (2008)\",\"year\":\"2008\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_3.jpg\",\"crew\":\"Christopher Nolan (dir.), Christian Bale, Heath Ledger\",\"imDbRating\":\"9.0\",\"imDbRatingCount\":\"2583633\"},{\"id\":\"tt0071562\",\"rank\":\"4\",\"title\":\"The Godfather: Part II\",\"fullTitle\":\"The Godfather: Part II (1974)\",\"year\":\"1974\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_4.jpg\",\"crew\":\"Francis Ford Coppola (dir.), Al Pacino, Robert De Niro\",\"imDbRating\":\"9.0\",\"imDbRatingCount\":\"1242972\"},{\"id\":\"tt0050083\",\"rank\":\"5\",\"title\":\"12 Angry Men\",\"fullTitle\":\"12 Angry Men (1957)\",\"year\":\"1957\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_5.jpg\",\"crew\":\"Sidney Lumet (dir.), Henry Fonda, Lee J. Cobb\",\"imDbRating\":\"8.9\",\"imDbRatingCount\":\"771737\"},{\"id\":\"tt0108052\",\"rank\":\"6\",\"title\":\"Schindler's List\",\"fullTitle\":\"Schindler's List (1993)\",\"year\":\"1993\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_6.jpg\",\"crew\":\"Steven Spielberg (dir.), Liam Neeson, Ralph Fiennes\",\"imDbRating\":\"8.9\",\"imDbRatingCount\":\"1327412\"},{\"id\":\"tt0167260\",\"rank\":\"7\",\"title\":\"The Lord of the Rings: The Return of the King\",\"fullTitle\":\"The Lord of the Rings: The Return of the King (2003)\",\"year\":\"2003\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_7.jpg\",\"crew\":\"Peter Jackson (dir.), Elijah Wood, Viggo Mortensen\",\"imDbRating\":\"8.9\",\"imDbRatingCount\":\"1792632\"},{\"id\":\"tt0110912\",\"rank\":\"8\",\"title\":\"Pulp Fiction\",\"fullTitle\":\"Pulp Fiction (1994)\",\"year\":\"1994\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_8.jpg\",\"crew\":\"Quentin Tarantino (dir.), John Travolta, Uma Thurman\",\"imDbRating\":\"8.9\",\"imDbRatingCount\":\"2001000\"},{\"id\":\"tt0120737\",\"rank\":\"9\",\"title\":\"The Lord of the Rings: The Fellowship of the Ring\",\"fullTitle\":\"The Lord of the Rings: The Fellowship of the Ring (2001)\",\"year\":\"2001\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_9.jpg\",\"crew\":\"Peter Jackson (dir.), Elijah Wood, Ian McKellen\",\"imDbRating\":\"8.8\",\"imDbRatingCount\":\"1813702\"},{\"id\":\"tt0060196\",\"rank\":\"10\",\"title\":\"The Good, the Bad and the Ugly\",\"fullTitle\":\"The Good, the Bad and the Ugly (1966)\",\"year\":\"1966\",\"image\":\"https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_10.jpg\",\"crew\":\"Sergio Leone (dir.), Clint Eastwood, Eli Wallach\",\"imDbRating\":\"8.8\",\"imDbRatingCount\":\"748209\"}],\"errorMessage\":\"\"}";
        //this.body = response.body();
    }

    public String getBody() {
        return body;
    }
}
