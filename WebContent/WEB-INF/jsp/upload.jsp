<html>
    <head>
        <title>Stats Upload</title>
        <base href="/Stats/"/>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
       	<link rel="stylesheet" href="http://www.watfordcheetahs.com/css/main.css" />
    </head>
    <body>
    	<div id="container">
	        <h1 class="title">Stats Upload</h1>
	        <div id=content-full>
		        <div class="bordered">
			        <form id="uploadform" method="post" enctype="multipart/form-data">
			            <input type="text" name="name"/>
			            <input type="file" name="file" id="fileinput"/>
			            <input type="submit"/>
			        </form>
		        </div>
		        <div id="results" class="bordered"></div>
	        </div>  
        </div>      
        <script>$('#uploadform').submit(function(event) {
            	event.preventDefault();

				var formData = new FormData();
				var fileinput = $('#fileinput');
				formData.append('file', fileinput[0].files[0])
				
				$.ajax({
				    url: '/Stats/upload',
				    data: formData,
				    cache: false,
				    contentType: false,
				    processData: false,
				    type: 'POST',
				    success: function(resp){
						$('#results').html(resp.result);
				    }
				});								
				
				return false;
            });
        </script>
    </body>
</html>