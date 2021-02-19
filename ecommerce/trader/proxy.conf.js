const PROXY_CONFIG = [
    {
        context: [
            "/bitstamp",
            "/coinbase",
            "/itbit",
            "/bitfinex",
            "/myuser"
        ],
        target: "http://localhost:8083",
        secure: false
    }
]

module.exports = PROXY_CONFIG;