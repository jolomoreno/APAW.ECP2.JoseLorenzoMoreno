package api;

import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.CompeticionDto;
import api.exceptions.NotFoundException;
import api.exceptions.RequestInvalidException;
import api.exceptions.ArgumentNotValidException;
import api.apiControllers.CompeticionApiController;
import http.HttpRequest;
import http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.appender.AbstractAppender;

public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private CompeticionApiController competicionApiController = new CompeticionApiController();

    public void submit(HttpRequest request, HttpResponse response) {

        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
                case PATCH:
                    throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
                case DELETE:
                    this.doDelete(request);
                    break;
                default:
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(http.HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(http.HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            LogManager.getLogger(this.getClass()).error("UNEXPECTED   ERROR: " + exception);
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(CompeticionApiController.COMPETICIONES)) {
            response.setBody(this.competicionApiController.create((CompeticionDto) request.getBody()));
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(CompeticionApiController.COMPETICIONES)) {
            response.setBody(this.competicionApiController.readAll());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(CompeticionApiController.COMPETICIONES + CompeticionApiController.ID)) {
            this.competicionApiController.update(request.getPath(1), (CompeticionDto) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doDelete(HttpRequest request) {
        if (request.isEqualsPath(CompeticionApiController.COMPETICIONES + CompeticionApiController.ID)) {
            this.competicionApiController.delete(request.getPath(1));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }
}
