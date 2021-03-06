[#ftl]
[#import "spring.ftl" as spring/]
[#assign xhtmlCompliant = true in spring/]
[#import "include/pageTemplate.ftl" as page]
[#escape x as x?html]
    [@page.pageTemplate "Test Page"]
    <h1>${nerderyInfo.name}</h1>
    <p>${nerderyInfo.description}</p>
    <div>Websites:
        <ul>
            [#list nerderyInfo.urls as url]
                <li>
                    <a href="${url}">${url}</a>
                </li>
            [/#list]
        </ul>
    </div>
    <div>Projects:
        <ul>
            [#list projects as project]
                <li>Project &quot;${project.name}&quot; ran for <em>${project.hours} hours</em> with ${project.developers} developers.</li>
            [/#list]
        </ul>
    </div>
    [/@page.pageTemplate]
[/#escape]