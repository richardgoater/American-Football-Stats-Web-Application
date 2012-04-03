<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Stats Upload</title>
        <base href="/Stats/"/>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
       	<link rel="stylesheet" href="http://www.watfordcheetahs.com/css/main.css" />
       	<style>
       		tr {border-bottom: 2px solid #4D4D4D; padding-bottom: 20px; padding-top: 20px}
       		tr.top {padding-top: 0px;}
       		tr.bottom {border-bottom: none; padding-bottom: 0px}
       		td {border-right: none; border-bottom: inherit; padding-bottom: inherit; padding-top: inherit}
       	</style>
    </head>
    <body>
    	<div id="container">
	        <h1 class="title">Stats Upload</h1>
	        <div id=content-full>
		        <div class="bordered">
		        	<form id="uploadform" method="post" enctype="multipart/form-data">
			            <table style="width: 100%; border-spacing: 0px;">
			            	<tr class="top">
			            		<td>Select a Season:<br /> 
			            			<select id="season" onchange="updateWeekSelect()">
			            				<c:forEach var="season" items="${seasons}">
                							<option value="${season.seasonid}">${season.year}</option>
              							</c:forEach>
			            			</select>
			            		</td>
			            		<td>Or add a new Season:<br /> 
			            			<input type="text" id="addSeason" maxlength="4"/><br />
			            			<input type="button" onclick="addSeason()" value="Submit"/>
			            		</td>
			            		<td>Or remove selected<br />
			            			(and associated data):<br /> 
			            			<input type="button" onclick="deleteSeason()" value="Remove"/>
			            		</td>
			            	</tr>
			            	<tr>
			            		<td>
			            			Select a Week:<br /> 
			            			<select id="weeknum">
			            				<option>&lt;Please select a season&gt;</option>
			            			</select>
			            		</td>
			            		<td>Or add a new one:<br /> 
			            			<input type="text" id="addWeeknum" maxlength="2" value="Num"/><br />
			            			<input type="text" id="addWeekOpponent" value="Opponent"/><br />
			            			<input type="button" onclick="addWeek()" value="Submit"/>
			            		</td>
			            		<td>Or remove selected<br />
			            			(and associated data):<br />
			            			<input type="button" onclick="deleteWeek()" value="Remove"/>
			            		</td>
			            	</tr>
			            	<tr class="bottom">
			            		<td class="end">Select a file to upload:</td>
			            		<td class="end"><input type="file" name="file" id="fileinput"/></td>
			            		<td class="end"><input type="submit"/></td>
			            	</tr>	
			            </table>
			        </form>
		        </div>
		        <h2 style="margin-top:20px;">Results</h2>
		        <div id="results" class="bordered" style="margin-top: 0px;"></div>
	        </div>  
        </div>      
        <script>$('#uploadform').submit(function(event) {
            	event.preventDefault();

				var formData = new FormData();
				var fileinput = $('#fileinput');
				formData.append('file', fileinput[0].files[0]);
				formData.append('season', $('#season').val());
				formData.append('weeknum', $('#weeknum').val());
				
				$.ajax({
				    url: '/Stats/upload',
				    data: formData,
				    cache: false,
				    contentType: false,
				    processData: false,
				    type: 'POST',
				    success: function(resp){
						$('#results').empty().html(resp.result);
				    }
				});								
				
				return false;
            });
        
        	function updateWeekSelect() {
        		var season = $('#season').val();
        		
        		$.getJSON('upload/seasons/' + season,
        			function(weeks) {
        				var weekSelect = $('#weeknum');
        				$(weekSelect).empty();
        				for(var i = 0; i < weeks.length; i++) {
        					var week = weeks[i];
        					$(weekSelect).append( $('<option>', {value: week.weeknum }).text(week.displayName));	
        				}
        			}
        		);
        	}
        </script>
    </body>
</html>