package tr.com.altpro.imdb.boundary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.altpro.imdb.control.ImdbService;
import tr.com.altpro.imdb.response.ImdbResponse;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/get")
public class ImdbResource {

    @Inject
    ImdbService imdbService;

    @RequestMapping(value = "/getByName",method = RequestMethod.GET)
    public ResponseEntity<ImdbResponse> getByName(@RequestParam(value = "name",required = true)String name) {

        ResponseEntity<ImdbResponse> responseEntity=imdbService.getByName(name);
        if (name != null && !name.isEmpty()) {
            return responseEntity;
        }
        return null;
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public ResponseEntity<ImdbResponse> getById(@RequestParam(value = "id",required = true)String id) {

        ResponseEntity<ImdbResponse> responseEntity=imdbService.getById(id);
        if (id != null && !id.isEmpty()) {
            return responseEntity;
        }
        return null;
    }

}

