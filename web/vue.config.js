const path = require('path')
const resolve = dir => path.join(__dirname, dir)
module.exports ={
    chainWebpack: config => {
        config.resolve.alias
            .set("@", resolve("src"))
        const rawArgv = process.argv.slice(2)
        if ('production' === process.env.NODE_ENV && rawArgv.includes('--report')){
            const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin
            config
                .plugin('webpack-bundle-analyzer')
                .use(BundleAnalyzerPlugin)
                .init(Plugin => new Plugin())
        }
    },
    devServer:{
        proxy:{
            '/api':{
                target:'http://localhost:9000',
                pathRewrite: {'^/api' : ''}
            }
        }
    },
    outputDir:'../back/src/main/resources/static/web',
    indexPath:'../../templates/web.html',
    configureWebpack:{
        externals:{
            'vue': 'Vue',
            'vue-router': 'VueRouter',
            'vuex': 'Vuex',
            'axios': 'axios',
            'element-ui':'ELEMENT',
        }
    }
}
