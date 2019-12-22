module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8800/',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': '/',
                },
            },
        },
    },
}