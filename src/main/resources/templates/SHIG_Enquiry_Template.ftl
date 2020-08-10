<#ftl encoding="utf-8">
<?xml version="1.0"?><!DOCTYPE pdf PUBLIC "-//big.faceless.org//report" "report-1.1.dtd">
<pdf>
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Mono&family=Sonsie+One&display=swap"
              rel="stylesheet">

        <style type="text/css">
            #body {
                width: 100%;
                height: 100%;
                font-family: 'Roboto Mono', monospace;
                font-size: 16px;
            }

            table {
                margin: 10px 0;
                width: 100%;
                border: 1px solid black;
            }
            .label{
                font-weight: 900;
                color: black;
            }
            .value{
                font-weight: 400;
                color: gray;
            }
        </style>
    </head>
    <body>
    <div id="body">
        <table id="header">
            <tr>
                <td class="label">New Enquiry from:</td>
                <td class="value">${name}</td>
            </tr>
            <tr>
                <td class="label">Preferred Contact:</td>
                <td class="value">${preferred_contact}</td>
            </tr>
            <tr>
                <td class="label">Subject:</td>
                <td class="value">${contact_reason}</td>
            </tr>
        </table>
        <table id="contact_details">
            <tr>
                <td class="label">Email:</td>
                <td class="value">${email}</td>
            </tr>
            <tr>
                <td class="label">Mobile:</td>
                <td class="value">${mobile}</td>
            </tr>
        </table>
        <table id="project_details">
            <tr>
                <td class="label">Title:</td>
                <td class="value">${contact_reason}</td>
            </tr>
            <tr>
                <td class="label">Budget:</td>
                <td class="value">${budget}</td>
            </tr>
            <tr>
                <td class="label">Deadline:</td>
                <td class="value">${deadline}</td>
            </tr>
        </table>
        <table id="additional_details">
            <tr>
                <td class="label">Estimated no. of Pages:</td>
                <td class="value">${no_of_pages}</td>
            </tr>
            <tr>
                <td class="label">DB / Users Required:</td>
                <td class="value">${db_required} / ${users_required}</td>
            </tr>
            <tr>
                <td class="label">Domain Purchased Already:</td>
                <td class="value">${domain_purchased}</td>
            </tr>
        </table>
    </div>
    </body>
</pdf>
