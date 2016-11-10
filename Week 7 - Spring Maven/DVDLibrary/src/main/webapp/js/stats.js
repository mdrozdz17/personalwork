// #1: document ready
$(document).ready(function () {
    drawChart();
});
// #2: draw the bar chart
function drawChart() {
    // #3: dummy data - will be replaced with Ajax call
    var data = google.visualization.arrayToDataTable([
        ['DVD', '# DVD'],
        ['Action', 10],
        ['Comedy', 11],
        ['Romance', 6],
        ['Horror', 18]
    ]);
    // #4: this sets up the size of the chart, the main title, and the axis titles
    var options = {
        title: 'DVD Collection',
        vAxis: {title: 'Genre', titleTextStyle: {color: 'red'}},
        hAxis: {title: 'Number of DVDS', titleTextStyle: {color: 'red'}},
        'width': 500,
        'height': 400
    };
    // #5: create a new BarChart object, handing it the div into which we want it to render
    var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
    // #6: tell the chart to draw itself
    chart.draw(data, options);
}
