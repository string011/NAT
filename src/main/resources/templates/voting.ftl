	[#ftl]
	[#import "spring.ftl" as spring/]
	[#assign xhtmlCompliant = true in spring/]
	[#import "include/snackShopPageTemplate.ftl" as page]
	[#escape x as x?html]
    [@page.pageTemplate "Snack Shop Page"]
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script type="text/javascript" >
		function initializeVotesRemaining(){
		    	var remaining = getRemainingVotes();
		        if (remaining > 0 && remaining < 3) {
		           // change indicator yellow.
			        $(".counter.counter_green").addClass("isHidden");
			        $(".counter.counter_yellow").removeClass("isHidden");
			        $(".counter.counter_yellow").text(remaining);
		        } else if (remaining == 0){
			        // change indicator red.
			        $(".counter.counter_green").addClass("isHidden");
			        $(".counter.counter_yellow").addClass("isHidden");
			        $(".counter.counter_red").removeClass("isHidden");
			        $(".counter.counter_red").text(remaining);
		        } else if (remaining == 3){
			        // change indicator green.
			        $(".counter.counter_green").removeClass("isHidden");
			        $(".counter.counter_yellow").addClass("isHidden");
			        $(".counter.counter_red").addClass("isHidden");
			        $(".counter.counter_green").text(remaining);
		        }
		};
		$(document).ready(function() {
			initializeVotesRemaining();
		});
	
    // XXX should really put this in its own .js file.
    // Forcing a post request with the choosen name of the snack.
    // Not sure how to make this more elegant with html form tag.
    // This is used by the onClick on the buttons in the voting section.
    
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
	    return null;
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
	
	function getRemainingVotes(){
		return 3 - readOrCreateVoteCount();
	}
	
	function incrementVoteCount(){
	   var value = readOrCreateVoteCount();
	   ++value;
	   // I was trying to set the cookie value w/o overwriting the expiration date.
	   // document.cookie = name + "=" + value + "; path=/";
     	createCookie("voteCount", value, 30);
	}
	
	function sendVote(id) {
        if (readOrCreateVoteCount() == 3){
        	alert("You can only vote 3 times in a month");
        	return;
        }
	     var obj = {"name":"snackName","id":id};
	     var json = JSON.stringify(obj);
	     console.log(obj)
	     console.log(json);
		$.ajax({ 
		    url: "/voted", 
		    type: 'POST', 
		    dataType: 'json', 
		    data: json,
		    contentType: 'application/json',
		    mimeType: 'application/json',
		    success: function(data) { 
				incrementVoteCount();
		    	var cnt = parseInt(data.voteCount);
		    	var remaining = getRemainingVotes();
		        var td = document.getElementById("count_"+id).innerText=data.voteCount;
		        var btn = document.getElementById(id);
	            btn.children[0].className="icon-check icon-check_voted";
	            initializeVotesRemaining();
		    },
		    error:function(data,status,er) { 
		        alert("error: "+data+" status: "+status+" er:"+er);
		    }
		});
		
	}
	</script>
	    <div>
	    <div class="wrapper">
	        <div class="content" role="main">
	            <div class="shelf shelf_5">
	                <h1 class="hdg hdg_1">Voting</h1>
	            </div>
	            <div class="shelf shelf_2">
	                <p>You are able to vote for up to three selections each month.</p>
	            </div>
	            <div class="shelf shelf_2">
	                <div class="voteBox">
	                    <div class="voteBox-hd">
	                        <h2 class="hdg hdg_3">Votes Remaining</h2>
	                    </div>
	                    <div class="voteBox-body">
	                        <p class="counter counter_green "></p>
	                        <p class="counter counter_yellow "></p>
	                        <p class="counter counter_red "></p>
	                    </div>
	                </div>
	            </div>
	            <div class="shelf shelf_2">
	                <p class="error isHidden">Opps! You have already voted the total allowed times this month.<br />Come back next month to vote again!</p>
	            </div>
	            <div class="split">
	                <div class="shelf shelf_2">
	                    <div class="shelf">
	                        <h2 class="hdg hdg_2 mix-hdg_centered ">Snacks Always Purchased</h2>
	                    </div>
	                    <ul class="list list_centered">
				        <ul>
				            [#list snackShopInfo.snacks as snack ]
				                [#if !snack.optional]
					                <li>
						                <p> ${snack.name} </p>
					                </li>
				                [/#if]
				            [/#list]
				        </ul>
                    </ul>
                </div>
            </div>
            <div class="split">
                <div class="shelf shelf_2">
                    <div class="shelf">
                        <h2 class="hdg hdg_2 mix-hdg_centered ">Snacks suggested this month</h2>
                    </div>
                    <div class="shelf shelf_5">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Snack Food</th>
                                    <th scope="col">Current Votes</th>
                                    <th scope="col">VOTE</th>
                                    <th scope="col">Last Date Purchased</th>
                                </tr>
                            </thead>
                            <tbody>
				            [#list snackShopInfo.snacks as snack ]
                            	[#if snack.optional]
		                            <tr>
		                                <td>${snack.name}</td>
		                                <td id="count_${snack.id?c}">${snack.voteCount}</td>
		                                <td>
		                                [#if snack.voteCount != 0]
		                                    <button class="btn btn_clear"><i class="icon-check icon-check_voted"></i>
	                                    [#else]
	                                        <button id="${snack.id?c}" class="btn btn_clear" onclick="sendVote(id)"><i class="icon-check icon-check_noVote"></i>
	                                        
                                        [/#if]
		                                </td>
	                                    <td>${snack.lastPurchaseDate}</td>
		                            </tr>
                                [/#if]
			                [/#list]
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- /content -->
    </div>
    <!-- /wrapper -->
    [/@page.pageTemplate]
[/#escape]