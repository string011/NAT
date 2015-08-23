[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/pageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Snack Shop Page"]
    <div>
    <h1>
    Welcome to the snack shop.
    </h1>
    [/@page.pageTemplate]
[/#escape]