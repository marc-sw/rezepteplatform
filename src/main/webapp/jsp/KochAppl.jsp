<%@page import="java.nio.file.Paths"%>
<%@page import="java.io.File"%>
<%@page import="de.hwg_lu.bwi520.bean.AccountBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="account" class="de.hwg_lu.bwi520.bean.AccountBean" scope="session"></jsp:useBean>
<jsp:useBean id="rezeptErstellen" class="de.hwg_lu.bwi520.bean.RezeptErstellenBean" scope="session"></jsp:useBean>
<jsp:useBean id ="rb" class ="de.hwg_lu.bwi520.bean.RezeptBean" scope ="session"/>
<%	
	String redirectUrl = "./StartView.jsp";
	String username = request.getParameter("username");
	String passwort = request.getParameter("passwort");	
	String kategoriesuche = request.getParameter("kategoriesuche");

	
	if (request.getParameter("Registrieren") != null)
	{
		account.register(username, passwort);
	} 
	else if (request.getParameter("Anmelden") != null)
	{
		account.login(username, passwort);
	} 
	else if (request.getParameter("abmelden") != null) 
	{
		account.logout();
	} 
	else if (request.getParameter("zutatHinzufuegen") != null) 
	{
		String name = request.getParameter("zutatName");
		float menge = Float.parseFloat(request.getParameter("zutatMenge"));
		String einheit = request.getParameter("zutatEinheit");
		rezeptErstellen.zutatHinzufuegen(name, menge, einheit);
		redirectUrl = "./RezeptErstellenView.jsp";
	} 
	else if (kategoriesuche != null)	
	{
		rb.setKategorieSuche(kategoriesuche);
		redirectUrl = "./RezeptListeView.jsp";
	}
	else if (request.getParameter("rezeptErstellen") != null) 
	{
		String titel = request.getParameter("titel");
        int dauer = Integer.parseInt(request.getParameter("dauer"));
        String zubereitung = request.getParameter("zubereitung");
        String kategorie = request.getParameter("kategorie");
        String uploadPath = application.getRealPath("") + File.separator + "img/uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();
	
        // Bild-Part holen
        Part filePart = request.getPart("bild");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String filePath = uploadPath + File.separator + fileName;
	
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);

        for (FileItem item : items) {
            if (!item.isFormField()) {
                // normale Form-Felder
                String fileName2 = new File(item.getName()).getName();
                File file = new File(uploadPath + File.separator + fileName2);
                item.write(file);
                bildPfad = "img/uploads/" + fileName2; 
                             
            }
        
        	// Datei speichern
       		 filePart.write(filePath);

       		 rezeptErstellen.erstelleRezept(titel, fileName, dauer, zubereitung, kategorie);
        
			}
	response.sendRedirect(redirectUrl);		
		%>
</body>
</html>