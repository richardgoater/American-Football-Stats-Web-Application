<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Stats Upload</title>
        <base href="${pageContext.request.contextPath}/"/>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" src="res/upload.js"></script>
       	<link rel="stylesheet" href="http://www.watfordcheetahs.com/css/main.css" />
       	<style>
       		h1.title {margin-top: 0px; padding-top: 20px;}
       		tr {border-bottom: 2px solid #4D4D4D; padding-bottom: 20px; padding-top: 20px;}
       		tr.top {padding-top: 0px;}
       		tr.bottom {border-bottom: none; padding-bottom: 0px;}
       		td {border-right: none; border-bottom: inherit; padding-bottom: inherit; padding-top: inherit; color: #FFCE03;}
       		td.inner {border: none; padding: 0px;}
       		td.aLeft {text-align: left;}
       		td.aRight {text-align: right;}
       		span.error {color: red;}
       		div.spinner {display: none;}
       		div.spinner.show {display: inline;}
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
			            			<select id="season" onchange="getWeeksForSeason()">
			            				<c:forEach var="season" items="${seasons}">
                							<option value="${season.seasonid}">${season.year}</option>
              							</c:forEach>
			            			</select>
			            		</td>
			            		<td>Or add a new Season:<br /> 
			            			<input type="text" id="newSeason" maxlength="4"/><br />
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
			            		<td align="center">Or add a new Week:<br />
			            			<table style="width: 100%">
			            				<tr>
			            					<td class="inner aRight">Week:</td>
			            					<td class="inner aLeft"><input type="text" id="newWeeknum" maxlength="2"/></td>
			            				</tr>
			            				<tr>
			            					<td class="inner aRight">Opponent:</td>
			            					<td class="inner aLeft"><input type="text" id="newWeekOpponent"/></td>
			            				</tr>
			            			</table>
			            			Home? <input type="checkbox" id="isHome"/><br />
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
			            		<td class="end"><input type="button" onclick="uploadFile()" value="Submit"/>
			            			<div class="spinner"><img src="res/spinner.gif"/></div></td>
			            	</tr>	
			            </table>
			        </form>
		        </div>
		        <h2 style="margin-top:20px;">Results</h2>
		        <div id="results" class="bordered" style="margin-top: 0px;"></div>
	        </div>  
        </div>
    </body>
</html>