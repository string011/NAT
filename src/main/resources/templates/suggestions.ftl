[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/snackShopPageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Snack Shop Page"]
    <div>
    <h1>
    Welcome to the snack shop.
    </h1>
    <div class="wrapper">
        <div class="content" role="main">
            <div class="shelf shelf_5">
                <h2 class="hdg hdg_1">Suggestions</h2>
            </div>
            
            <div class="shelf shelf_2">
            [#if xerror??]
                <div class="error"><p>${xerror.errorMessage}</p></div>
            [/#if]
                
                
                <div class="error isHidden"> 
                	<p> You have attempted to add more than the allowed number of suggestions per month!
	                    <br />There is a total of three allowed suggestions per month.</div>
	                </p>
                <div class="error isHidden">You have attempted to add a suggestion that already exists!</div>
                <div class="error isHidden">You have not completed information requested.</div>
            </div>
            <div class="content-centered">
                <div class="shelf shelf_2">
                

                    <form action="/suggestion" th:action="@{/suggestion}" th:object="${suggestions}" method="post">
                    
                        <fieldset class="shelf shelf_2">
                            <div class="shelf shelf_2">
                                <div class="shelf">
                                    <label for="snackOptions">
                                        <h2 class="hdg hdg_2">Select a snack from the list</h2>
                                    </label>
                                </div>
                                <select name="snackOptions" id="snackOptions">
					            [#list suggestions.suggestions as sug ]
                                    <option value="snack1" name="${sug.name}">${sug.name}</option>
					            [/#list]
                                </select>
                            </div>
                        </fieldset>
                        <div class="shelf shelf_5">
                            <p class="hdg hdg_1">or</p>
                        </div>
                        <fieldset class="shelf shelf_5">
                            <div class="shelf">
                                <label for="suggestionInput">
                                    <h2 class="hdg hdg_2">Enter new snack suggestion &amp; purchasing location</h2>
                                </label>
                            </div>
                            <div class="shelf">
                                <label for="suggestionLocation" class="isHidden">Suggestion</label>
                                <input type="text" id="suggestionInput" name="name" th:field="*{name}" placeholder="Snack Suggestion" />
                            </div>
                            <div class="shelf">
                                <label for="suggestionLocation" class="isHidden">Location</label>
                                <input type="text" id="suggestionLocation" name="location" th:field="*{location}" placeholder="Location" class="" />
                            </div>
                        </fieldset>
                        <input type="submit" value="Suggest this Snack!" class="btn">
                    </form>
                </div>
            </div>
        </div>
        <!-- /content -->
    </div>
    <!-- /wrapper -->
    [/@page.pageTemplate]
[/#escape]