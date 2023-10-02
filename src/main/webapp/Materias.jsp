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
        <link rel="stylesheet" href="css/estilos.css">
      
        <link rel="stylesheet" href="css/estilos.css">
        
        <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
    </head>
<body id="body">
    
    <header>
        <div class="icon__menu">
            <i class="fas fa-bars" id="btn_open"></i>
            
        </div>
       <strong><h4 class="header font-weight-bold">ㅤGESTOR DE MATERIAS</h4></strong> 
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
            
            <a href="#" class="selected" >
                <div class="option" >
                    <i class="fas fa-book" title="Portafolio"></i>
                    <h4>Materias</h4>
                </div>
            </a>
            
            <a href="Actividades.jsp">
                <div class="option">
                    <i class="fas fa-paint-brush" title="Cursos"></i>
                    <h4>Actividades</h4>
                </div>
            </a>

            <a href="Ponderados.jsp">
                <div class="option">
                    <i class="far fa-file-alt" title="Blog"></i>
                    <h4>Notas</h4>
                </div>
            </a>
            

        </div>

    </div>

     <main>
        <div class="cards2">
            <form >
                <h3>Crear materia</h3>
                <br>
                <div class="form-group">
                  <label>Nombres materia:</label>
                  <input type="text" name="nombre" class="form-control"  required placeholder="Ingrese el nombre de la materia">
                </div>
              
                <div class="form-group">
                  <label >Codigo:</label>
                  <input type="number" name="codigo" class="form-control"  required placeholder="Ingrese el codigo de la materia">
                </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
              </form>
              <br>
    <br>
    <div class="header_fixed">
        <table>
            <thead>
                <tr>
                    <th>Id.</th>
                    <th>Nombre de la materia</th>
                    <th>Codigo</th>
                    <th>Estado</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Vejata Gupta</td>
                    <td>Vejata@gmail.com</td>
                    <td>Engineering</td>
                    <td><!-- Botón rojo con un ícono de FontAwesome -->
                        <button class="btn btn-danger btn-sm" title="Eliminar">
                            <i class="fas fa-exclamation-triangle"></i>
                        </button>
                        
                        <!-- Botón verde con un ícono de FontAwesome -->
                        <button class="btn btn-success btn-sm " title="activa/desactiva">
                            <i class="fas fa-check"></i>
                        </button>
                        
                        <!-- Botón con el ícono Tree -->
                        <button class="btn btn-Tree btn-sm" title="Editar">
                            <i class="fas fa-tree"></i>
                        </button>
                        
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Vejata Gupta</td>
                    <td>Vejata@gmail.com</td>
                    <td>Engineering</td>
                    <td><!-- Botón rojo con un ícono de FontAwesome -->
                        <button class="btn btn-danger btn-sm" title="Eliminar">
                            <i class="fas fa-exclamation-triangle"></i>
                        </button>
                        
                        <!-- Botón verde con un ícono de FontAwesome -->
                        <button class="btn btn-success btn-sm " title="activa/desactiva">
                            <i class="fas fa-check"></i>
                        </button>
                        
                        <!-- Botón con el ícono Tree -->
                        <button class="btn btn-Tree btn-sm" title="Editar">
                            <i class="fas fa-tree"></i>
                        </button>
                        
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Vejata Gupta</td>
                    <td>Vejata@gmail.com</td>
                    <td>Engineering</td>
                    <td><button class="btn btn-danger btn-sm" title="Eliminar">
                        <i class="fas fa-exclamation-triangle"></i>
                    </button>
                    
                    <!-- Botón verde con un ícono de FontAwesome -->
                    <button class="btn btn-success btn-sm " title="activa/desactiva">
                        <i class="fas fa-check"></i>
                    </button>
                    
                    <!-- Botón con el ícono Tree -->
                    <button class="btn btn-Tree btn-sm" title="Editar">
                        <i class="fas fa-tree"></i>
                    </button>
                        
                    </td>
                </tr>
               
            </tbody>
        </table>
    </div>
            </div>
        
    
    </main>
    <script src="js/script.js"></script>
</body>
</html>