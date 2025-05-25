package servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Jacket;
import service.JacketService;

import java.io.IOException;
import java.util.List;

@WebServlet("/jackets")
public class JacketServlet extends HttpServlet {
    private JacketService jacketService = new JacketService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        List<Jacket> jackets = jacketService.getAll();
        resp.getWriter().write(gson.toJson(jackets));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Jacket newJacket = gson.fromJson(req.getReader(), Jacket.class);
        jacketService.add(newJacket);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write(gson.toJson(newJacket));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID is missing");
            return;
        }
        int id = Integer.parseInt(pathInfo.substring(1));
        Jacket jacketToUpdate = gson.fromJson(req.getReader(), Jacket.class);
        jacketToUpdate.setId(id);

        if (jacketService.update(jacketToUpdate)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write(gson.toJson(jacketToUpdate));
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Jacket not found");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID is missing");
            return;
        }
        int id = Integer.parseInt(pathInfo.substring(1));

        if (jacketService.delete(id)) {
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Jacket not found");
        }
    }
}
