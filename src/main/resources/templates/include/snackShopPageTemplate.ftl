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
    <!-- <link rel="stylesheet" media="screen, projection" href="assets/styles/modern.css" />-->
   <link href="[@spring.url '/assets/styles/modern.css'/]" rel="stylesheet" type="text/css" media="screen"/>
    
</head>
<body class="no-js">
    [#nested]
</body>
</html>
[/#macro]
[/#escape]

