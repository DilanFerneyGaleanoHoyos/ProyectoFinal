<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú lateral responsive - MagtimusPro</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.18.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="estilos.css">
    

    <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
</head>
<body id="body">
    
    <header>
        <div class="icon__menu">
            <i class="fas fa-bars" id="btn_open"></i>
        </div>
    </header>

    <div class="menu__side" id="menu_side">

        <div class="name__page">
            <i class="fas fa-user fa-lg"></i>
            <h4>Sistema Notas</h4>
        </div>

        <div class="options__menu">	

            <a href="index.jsp" >
                <div class="option">
                    <i class="fas fa-home" title="Inicio"></i>
                    <h4>Inicio</h4>
                </div>
            </a>
            
            <a href="Materias.jsp"  >
                <div class="option" >
                    <i class="fas fa-book" title="Portafolio"></i>
                    <h4>Materias</h4>
                </div>
            </a>
            
            <a href="Actividades.jsp" >
                <div class="option">
                    <i class="fas fa-paint-brush" title="Cursos"></i>
                    <h4>Actividades</h4>
                </div>
            </a>

            <a href="Ponderados.jsp" class="selected">
                <div class="option">
                    <i class="far fa-file-alt" title="Blog"></i>
                    <h4>Notas</h4>
                </div>
            </a>
            

        </div>

    </div>

    <main>
        
    
    </main>

    <script src="script1.js"></script>
</body>
</html>