package tr.com.altpro.imdb.boundary;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.altpro.imdb.control.ImdbService;
import tr.com.altpro.imdb.response.ImdbResponse;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/get")
public class ImdbResource {

    @Inject
    ImdbService imdbService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @RequestMapping(value = "/getByName",method = RequestMethod.GET)
    public ResponseEntity<ImdbResponse> getByName(@RequestParam(value = "name",required = true)String name) {


        if (name != null && !name.isEmpty()) {
            return new ResponseEntity<ImdbResponse>(imdbService.getByName(name),HttpStatus.OK);
        }
        return null;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResponseEntity<ImdbResponse> getById(@RequestParam(value = "id",required = true)String id) {

        if (id != null && !id.isEmpty()) {
            return new ResponseEntity<ImdbResponse>(imdbService.getById(id),HttpStatus.OK);
        }
        return null;
    }

}

