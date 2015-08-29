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
                <h2 class="hdg hdg_1">Shopping List</h2>
            </div>
            <div class="shelf shelf_1">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Snack Name</th>
                            <th scope="col">Purchase Location</th>
                        </tr>
                    </thead>
                    <tbody>
                        [#list snackShopInfo.snacks as snack ]
	                        <tr>
				                <td> <p> ${snack.name} </p> </td>
				                <td> <p> ${snack.purchaseLocations} </p> </td>
	                        </tr>
			            [/#list]
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- /content -->
    </div>
    <!-- /wrapper -->
    [/@page.pageTemplate]
[/#escape]