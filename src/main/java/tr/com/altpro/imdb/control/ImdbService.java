package tr.com.altpro.imdb.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tr.com.altpro.imdb.model.Imdb;
import tr.com.altpro.imdb.response.ImdbResponse;

import javax.inject.Inject;

@Service
public class ImdbService {

    @Inject
    private RestTemplate restTemplate;

    public ResponseEntity<ImdbResponse> getByName(String name) {
        Imdb imdb = restTemplate.getForObject("http://www.omdbapi.com/?t="+name+"&apikey=86f1cb3&plot=full",Imdb.class);
        ImdbResponse imdbResponse = convert(imdb);
        return new ResponseEntity<>(imdbResponse,HttpStatus.FOUND);
    }
    public ResponseEntity<ImdbResponse> getById(String id) {
        Imdb imdb = restTemplate.getForObject("http://www.omdbapi.com/?i="+id+"&apikey=86f1cb3&plot=full",Imdb.class);
        ImdbResponse imdbResponse = convert(imdb);
        return new ResponseEntity<>(imdbResponse,HttpStatus.FOUND);
    }

    private ImdbResponse convert(Imdb imdb) {

        ImdbResponse imdbResponse = new ImdbResponse();
        imdbResponse.setTitle(imdb.getTitle());
        imdbResponse.setType(imdb.getType());
        imdbResponse.setYear(imdb.getYear());
        imdbResponse.setRuntime(imdb.getRuntime());
        imdbResponse.setGenre(imdb.getGenre());
        imdbResponse.setWriter(imdb.getWriter());
        imdbResponse.setDirector(imdb.getDirector());
        imdbResponse.setActors(imdb.getActors());
        imdbResponse.setPlot(imdb.getPlot());
        imdbResponse.setLanguage(imdb.getLanguage());
        imdbResponse.setCountry(imdb.getCountry());
        imdbResponse.setImdbRating(imdb.getImdbRating());
        imdbResponse.setImdbVotes(imdb.getImdbVotes());
        imdbResponse.setAwards(imdb.getAwards());
        return imdbResponse;
    }
}
