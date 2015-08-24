[#ftl]
[#escape x as x?html]
[#macro pageTemplate title]
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- META DATA -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!--[if IE]><meta http-equiv="cleartype" content="on" /><![endif]-->
    <!-- SEO -->
    <title>SnaFoo - Nerdery Snack Food Ordering System</title>
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="57x57" href="assets/media/images/favicon/apple-touch-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="assets/media/images/favicon/apple-touch-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="assets/media/images/favicon/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="assets/media/images/favicon/apple-touch-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="assets/media/images/favicon/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="assets/media/images/favicon/apple-touch-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="assets/media/images/favicon/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="assets/media/images/favicon/apple-touch-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="assets/media/images/favicon/apple-touch-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="assets/media/images/favicon/favicon-192x192.png">
    <link rel="icon" type="image/png" sizes="160x160" href="assets/media/images/favicon/favicon-160x160.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/media/images/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/media/images/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/media/images/favicon/favicon-16x16.png">
    <meta name="msapplication-TileImage" content="assets/media/images/favicon/mstile-144x144.png">
    <meta name="msapplication-TileColor" content="#ff0000">
    <!-- STYLESHEETS -->
   <link href="[@spring.url '/assets/styles/modern.css'/]" rel="stylesheet" type="text/css" media="screen"/>
    
    <script>
    // Forcing a post request with the choosen name of the snack.
    // Not sure how to make this more elegant with html form tag.
    // This is used by the onClick in the voting section.
    function snackVote(snack) {
		var postData = "name="+snack;
		xmlhttp=new XMLHttpRequest()
		xmlhttp.open("POST", "/voted", false);
		//Send the proper header information along with the request
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.setRequestHeader("Content-length", postData.length);
		xmlhttp.send(postData);
		incrementVoteCount();
		window.location.reload(true)
	}
    
    function createCookie(name,value,days) {
	    var expires = "";
	    if (days) {
	        var date = new Date();
	        date.setTime(date.getTime()+(days*24*60*60*1000));
	        expires = "; expires=" + date.toGMTString();
	    } 
	    document.cookie = name+"="+value + expires + "; path=/";
	}
	
	function readCookie(name){
	    var pattern = RegExp(name + "=.[^;]*")
	    matched = document.cookie.match(pattern)
	    if(matched){
	        var cookie = matched[0].split('=')
	        var ret = cookie[1];
	        return ret;
	    }
	    return false
}

	function eraseCookie(name) {
	    createCookie(name,"",-1);
	}
	
	function readOrCreateVoteCount(){
	     var count = readCookie("voteCount");
	     if (count == null){
	        eraseCookie();
	     	createCookie("voteCount", 0, 30);
	     	return 0;
	     }
	     return count;
	}
	
	function incrementVoteCount(){
	   var value = readOrCreateVoteCount();
	   ++value;
	   // I was trying to set the cookie value w/o overwriting the expiration date.
	   // document.cookie = name + "=" + value + "; path=/";
     	createCookie("voteCount", value, 30);
	}
    </script>
    
</head>
<body class="no-js">

    <div class="masthead" role="banner">
        <div class="masthead-hd">
            <h1 class="hdg hdg_1 mix-hdg_extraBold"><a href="index.html">SnaFoo</a>
            </h1>
            <p class="masthead-hd-sub">Nerdery Snack Food Ordering System</p>
        </div>
        <div class="masthead-nav" role="navigation">
            <ul>
                <li><a href="/">Voting</a>
                </li>
                <li><a href="/suggestions">Suggestions</a>
                </li>
                <li><a href="/shoppinglist">Shopping List</a>
                </li>
            </ul>
        </div>
    </div>
    [#nested]
</body>
</html>
[/#macro]
[/#escape]

