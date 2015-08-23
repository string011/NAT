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
                        <tr>
                            <td>Donuts</td>
                            <td>Pies &amp; Cakes Bakery</td>
                        </tr>
                        <tr>
                            <td>Spam</td>
                            <td>Cub</td>
                        </tr>
                        <tr>
                            <td>Pistachios</td>
                            <td>Cub</td>
                        </tr>
                        <tr>
                            <td>Buckets of M&amp;M's</td>
                            <td>Cub</td>
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