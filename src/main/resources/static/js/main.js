initBTCPrice();
loadWebsites();

function loadWebsites() {

  const inclassWebsites = [
    {
      title: 'HelloServlet',
      url: '/hello-servlet'
    },
    {
      title: 'twoButtons',
      url: '/twoButtons'
    }
  ];

  const homeworkWebsites = [
    {
      title: 'Assignment 5',
      url: 'http://mason.gmu.edu/~omenyayl/assignment5/index.html'
    }
  ];

  let inclassWebsitesCollectionItemsHTML = "";
  for (let i = 0; i < inclassWebsites.length; i++) {
    const website = inclassWebsites[i];
    inclassWebsitesCollectionItemsHTML += `
    <a href="${website.url}" class="collection-item">${website.title}</a>
    `
  }

  let homeworkWebsitesCollectionItemsHTML = "";
  for (let i = 0; i < homeworkWebsites.length; i++) {
    const website = homeworkWebsites[i];
    homeworkWebsitesCollectionItemsHTML += `
    <a href="${website.url}" class="collection-item">${website.title}</a>
    `
  }

  $('#inclass-websites').html(inclassWebsitesCollectionItemsHTML);
  $('#homework-websites').html(homeworkWebsitesCollectionItemsHTML);
}

function initBTCPrice() {
  const btcPrice = $('#btc-price');
  const ws = new WebSocket("wss://ws.bitstamp.net/");

  const btcSubscribe = JSON.stringify({
    "event": "bts:subscribe",
    "data": {
      "channel": "live_trades_btcusd"
    }
  });

  ws.onopen = function() {
    console.log('Connection established!');
    ws.send(btcSubscribe);
  };

  ws.onmessage = function(event) {
    const price = JSON.parse(event.data).data.price_str;
    if (price) {
      btcPrice.html(`$${price}`);
    } else {
      btcPrice.html('loading...');
    }
  };
}
