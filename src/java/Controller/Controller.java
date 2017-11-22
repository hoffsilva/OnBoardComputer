/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Controller;

import Model.Curso;
import Model.EAD;
import Model.Materia;
import Model.Presencial;
import Service.CursoService;
import Service.EADService;
import Service.MateriaService;
import Service.PresencialService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoffhenrypereiradasilva
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nomeMateria = null;
        String nomeCurso = null;
        Curso curso = null;
        EAD ead = null;
        Presencial presencial = null;
        try {
            
            //pegando as informacoes da tela
            
            //pega o valor do cmapo de texto com nome: "nomeMateria"
            nomeMateria = request.getParameter("nomeMateria");
            //pega o valor do cmapo de texto com nome: "nomeCurso"
            nomeCurso = request.getParameter("nomeCurso");
            
            //criando o curos com a informacao vinda da tela 
            curso = new Curso(nomeCurso);

            
            //verifica se o valor do select chamado "tipoDeMateria" é EAD
            
            if (request.getParameter("tipoDeMateria").equals("EAD")) {
                //cria o objeto EAD
                ead = new EAD(1, nomeMateria, CursoService.insere(curso));
                //inserindo no banco de dados - USANDO O HIBERNATE
                ead = MateriaService.insereEAD(ead);
                //colocando o objeto presencial como null apenas por seguranca pra nao ter problemas na verificacao de exsitencia.
                presencial = null;
                 //devolvendo para a tela.
                request.setAttribute("ead", ead);
                //verifica se o valor do select chamado "tipoDeMateria" é Presencial
            } else if (request.getParameter("tipoDeMateria").equals("Presencial")) {
                //cria o objeto Presencial
                presencial = new Presencial(2, nomeMateria, CursoService.insere(curso));
                //inserindo no banco de dados - USANDO O HIBERNATE
                presencial = MateriaService.inserePresencial(presencial);
                //colocando o objeto ead como null apenas por seguranca pra nao ter problemas na verificacao de exsitencia.
                ead = null;
                 //devolvendo para a tela.
                request.setAttribute("presencial", presencial);
            }

        
        } catch (NumberFormatException e) {

        }
       
        //devolvendo para a tela.
        RequestDispatcher resultado = request.getRequestDispatcher("index.jsp");
        resultado.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
