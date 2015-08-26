	[#ftl]
	[#import "spring.ftl" as spring/]
	[#assign xhtmlCompliant = true in spring/]
	[#import "include/snackShopPageTemplate.ftl" as page]
	[#escape x as x?html]
	    [@page.pageTemplate "Snack Shop Page"]
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
	                        <p class="counter counter_green isHidden">3</p>
	                        <p class="counter counter_yellow">
	                           <script type="text/javascript">
	                              document.write(3 - readOrCreateVoteCount());
	                           </script>
                           </p>
	                        <p class="counter counter_red isHidden">1</p>
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
		                                <td>${snack.voteCount}</td>
		                                <td>
		                                [#if snack.voteCount != 0]
		                                    <button class="btn btn_clear"><i class="icon-check icon-check_voted"></i>
	                                    [#else]
	                                        <button id="${snack.name}" class="btn btn_clear" onclick="snackVote(id)"><i class="icon-check icon-check_noVote"></i>
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