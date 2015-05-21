<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <meta charset="utf-8">
        <title>Where I was</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/index.css" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Roboto:100,300,700' rel='stylesheet' type='text/css'>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <script src="js/jQuery.min.js"></script>
        <script src="js/index.js"></script>
        <link rel="icon" href="logo.ico">
        <script src="js/modal.js"></script>
        <link rel="stylesheet" href="css/styleInput.css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCqAOF3CcILJ6MwkGxW0DvojCwgokbAe5E&sensor=false">
        </script>
        <script type="text/javascript" src="js/autocomplete_map_geocoder.js">
        </script>
        <style>
            .window{
                display:none;                
                height:400px;
                position:absolute;
                left:0;
                top:0;
                background:#000;
                opacity: 0.7;
                z-index:9900;
                padding:10px;
                border-radius:10px;
                text-align: center;
            }
            
            .window a{
                color: #5cb85c;
                float: right;
                text-decoration: none;
            }
            
            a:hover{
                color: #398439;
            }
            
            #mascara{
                display:none;
                position:absolute;
                left:0;
                top:0;
                z-index:9000;
                background-color:#000;
            }

            .fechar{display:block; text-align:right;}
        </style>
        <script type="text/javascript">
            canvasControl = null;
            streetView = null;

            function inicialize() {
                var map;
                var panorama;

                canvasControl = new AutocompleteMapGeocoder('#map-canvas', '#address', '#latitude', '#lontitude', -6.889707, -38.56121817);
                map = canvasControl.map;

                $('button').click(function () {
                    panorama = map.getStreetView();
                    panorama.setPosition(new google.maps.LatLng($("#latitude").val(), $("#longitude").val()));
                    panorama.setPov(/** @type {google.maps.StreetViewPov} */ ({
                        heading: 180,
                        pitch: -50,
                        zoom: 0
                    }));
                    var toggle = panorama.getVisible();
                    if (toggle == false) {
                        panorama.setVisible(true);
                    } else {
                        panorama.setVisible(false);
                    }


                });
                adicionarMarcadores(map);
            }

            function adicionarMarcadores(map) {
            <c:forEach var="i" items="${images}">
                var marker = new google.maps.Marker({
                    map: map,
                    draggable: false,
                    icon: "${i.minImagePath}"                    
                });

                marker.setPosition(new google.maps.LatLng("${i.coord.lat}", "${i.coord.lng}"));

                google.maps.event.addListener(marker, 'click', function () {                                        
                    var alturaTela = $(document).height();
                    var larguraTela = $(window).width();

                    //colocando o fundo preto
                    $('#mascara').css({'width': larguraTela, 'height': alturaTela});
                    $('#mascara').fadeIn(1000);
                    $('#mascara').fadeTo("slow", 0.8);

                    var left = ($(window).width() / 2) - ($(modal).width() / 2);
                    var top = ($(window).height() / 2) - ($(modal).height() / 2);                                        
                    
                    $(modal).css({'top': top, 'left': left});
                    $(modal).html("<a href='#' id='x'>X</a><h6>${i.description}</h6><h6>${i.authors}</h6><h6>${i.date}</h6><img src="+"${i.imagePath}"+" height='80%' alt='imagem'>");
                    $(modal).show();

                });

            </c:forEach>
            }

        </script>

    </head>

    <body onload="inicialize()">    
        <div id="maps">
            <div id="addImageForm">
                <a href="#" id="fechar">x</a>
                <h3>Adicionar uma imagem</h3>
                <hr align="center" width="100%" size="1">
                <form action="cadastraimagem" method="post" enctype="multipart/form-data">
                    <label for="authors">Autores:</label>
                    <input type="text" name="authors" id="authors" placeholder="Douglas, Dijalma, Emanuel e João">
                    <label for="description">Descrição:</label>
                    <input type="text" name="description" id="description" placeholder="Esse dia foi louco">
                    <input class="data" type="date" name="end" id="end" required>
                    <input type="hidden" name="latitude" id="latitude" value="-6.889707" />
                    <input type="hidden" name="longitude" id="longitude" value="-38.56121817" />
                    <label for="image">Imagem:</label>
                    <input type="file" name="image" id="image">
                    <input type="submit" class="button" value="Salvar">
                </form>
            </div>
            <img src="images/search-icon.png" id="search">
            <img src="images/plus-icon.png" id="add">
            <img src="images/logo.png" class="logo">
            <div class="navbar-fixed-top navbar-center searchCity">
                <input type="text" name="address" id="address" placeholder="Digite aqui sua busca" />            
            </div>
            <div id="map-canvas"></div>            

            <div class="window" id="modal"></div>

            <div id="mascara"></div>
            <button id="button">Alternar para street view</button>
        </div>        

    </body>

</html>