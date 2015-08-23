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
                <div class="error isHidden">You have attempted to add more than the allowed number of suggestions per month!
                    <br />There is a total of three allowed suggestions per month.</div>
                <div class="error isHidden">You have attempted to add a suggestion that already exists!</div>
                <div class="error isHidden">You have not completed information requested.</div>
            </div>
            <div class="content-centered">
                <div class="shelf shelf_2">
                    <form method="" action="" class="form" novalidate>
                        <fieldset class="shelf shelf_2">
                            <div class="shelf shelf_2">
                                <div class="shelf">
                                    <label for="snackOptions">
                                        <h2 class="hdg hdg_2">Select a snack from the list</h2>
                                    </label>
                                </div>
                                <select name="snackOptions" id="snackOptions">
                                    <option value="snack1">snack suggestion 1</option>
                                    <option value="snack2">snack suggestion 2</option>
                                    <option value="snack3">snack suggestion 3</option>
                                    <option value="snack4">snack suggestion 4</option>
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
                                <input type="text" id="suggestionInput" placeholder="Snack Suggestion" />
                            </div>
                            <div class="shelf">
                                <label for="suggestionLocation" class="isHidden">Location</label>
                                <input type="text" id="suggestionLocation" placeholder="Location" class="" />
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