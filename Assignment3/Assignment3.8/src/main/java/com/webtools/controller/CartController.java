package com.webtools.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import com.webtools.model.Base;
import com.webtools.model.Book;
import com.webtools.model.Computer;
import com.webtools.model.Music;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sparshramchandani
 */
@WebServlet(urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List<Base> finalBookList = new ArrayList<>();
    List<Base> finalMusicList = new ArrayList<>();
    List<Base> finalComputerList = new ArrayList<>();

    protected void navigator(String param, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (param.equals("Book")) {
            Book book = new Book();
            request.setAttribute("list", book.getBook());
            request.setAttribute("item", param);
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/Items.jsp");
            rd.forward(request, response);
        } else if (param.equals("Music")) {
            Music music = new Music();
            request.setAttribute("list", music.getMusic());
            request.setAttribute("item", param);
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/Items.jsp");
            rd.forward(request, response);
        } else if (param.equals("Computer")) {
            Computer computer = new Computer();
            request.setAttribute("list", computer.getComputer());
            request.setAttribute("item", param);
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/Items.jsp");
            rd.forward(request, response);
        } else if (param.equals("Cart")) {
            request.setAttribute("item", param);
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/Cart.jsp");
            rd.forward(request, response);
        }
    }

    protected void addItemsToCart(String item, List<Base> baseList, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        if (item.equals("Book")) {
            finalBookList = baseList;
            session.setAttribute("booksList", finalBookList);
//            session.setAttribute("booksList", "Hello Books");
            Book book = new Book();
            request.setAttribute("list", book.getBook());
            request.setAttribute("item", item);
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/Items.jsp");
            rd.forward(request, response);
        } else if (item.equals("Music")) {
            finalMusicList = baseList;
            session.setAttribute("musicList", finalMusicList);
            Music music = new Music();
            request.setAttribute("list", music.getMusic());
            request.setAttribute("item", item);
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/Items.jsp");
            rd.forward(request, response);
        } else if (item.equals("Computer")) {
            finalComputerList = baseList;
            session.setAttribute("computerList", finalComputerList);
            Computer computer = new Computer();
            request.setAttribute("list", computer.getComputer());
            request.setAttribute("item", item);
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/Items.jsp");
            rd.forward(request, response);
        }
    }

    protected void removeItemsFromCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String[] itemsToRemove = request.getParameterValues("itemsToRemove");
        request.setAttribute("item", "Cart");
        List<String> itemsToRemoveList = Arrays.asList(itemsToRemove);

        if (itemsToRemoveList.contains("Books")) {
            String[] booksToRemove = request.getParameterValues("booksItems");
            if (!String.valueOf(booksToRemove).equals("null")) {
                List<Base> booksToRemoveList = new ArrayList<>();
                for (String itemsData1 : booksToRemove) {
                    String[] indiValues = itemsData1.split(",");
                    Base base = new Base(indiValues[0], Float.parseFloat(indiValues[1]));
                    booksToRemoveList.add(base);
                }

                for (int i = 0; i < finalBookList.size(); i++) {
                    for (int j = 0; j < booksToRemoveList.size(); j++) {
                        if (String.valueOf(finalBookList.get(i).getTitle()).equals(String.valueOf(booksToRemoveList.get(j).getTitle()))) {
                            finalBookList.remove(finalBookList.get(i));
                        }
                    }
                }
                session.setAttribute("booksList", finalBookList);
            }

        }

        if (itemsToRemoveList.contains("Music")) {
            String[] musicToRemove = request.getParameterValues("musicItems");
            if (!String.valueOf(musicToRemove).equals("null")) {
                List<Base> musicToRemoveList = new ArrayList<>();

                for (String itemsData1 : musicToRemove) {
                    String[] indiValues = itemsData1.split(",");

                    Base base = new Base(indiValues[0], Float.parseFloat(indiValues[1]));
                    musicToRemoveList.add(base);
                }

                for (int i = 0; i < finalMusicList.size(); i++) {
                    for (int j = 0; j < musicToRemoveList.size(); j++) {
                        if (String.valueOf(finalMusicList.get(i).getTitle()).equals(String.valueOf(musicToRemoveList.get(j).getTitle()))) {
                            finalMusicList.remove(finalMusicList.get(i));
                        }
                    }
                }
                session.setAttribute("musicList", finalMusicList);
            }

        }

        if (itemsToRemoveList.contains("Computer")) {
            String[] computerToRemove = request.getParameterValues("computerItems");
            if (!String.valueOf(computerToRemove).equals("null")) {
                List<Base> computerToRemoveList = new ArrayList<>();

                for (String itemsData1 : computerToRemove) {
                    String[] indiValues = itemsData1.split(",");

                    Base base = new Base(indiValues[0], Float.parseFloat(indiValues[1]));
                    computerToRemoveList.add(base);
                }
                for (int i = 0; i < finalComputerList.size(); i++) {
                    for (int j = 0; j < computerToRemoveList.size(); j++) {
                        if (String.valueOf(finalComputerList.get(i).getTitle()).equals(String.valueOf(computerToRemoveList.get(j).getTitle()))) {
                            finalComputerList.remove(finalComputerList.get(i));
                        }
                    }
                }
                session.setAttribute("computerList", finalComputerList);
            }

        }
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/Cart.jsp");
        rd.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (!(String.valueOf(request.getParameter("item"))).equals("null")) {
                String item = request.getParameter("item");
                if (item.equals("Cart")) {
                    removeItemsFromCart(request, response, session);
                } else {
                    String[] itemsData = request.getParameterValues("items");
                    List<Base> baseList = new ArrayList<>();
                    for (String itemsData1 : itemsData) {
                        String[] indiValues = itemsData1.split(",");
                        Base base = new Base(indiValues[0], Float.parseFloat(indiValues[1]));
                        baseList.add(base);
                    }
                    addItemsToCart(item, baseList, request, response, session);
                }
            } else {
                String param = request.getParameter("param");
                navigator(param, request, response);
            }

        }
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
