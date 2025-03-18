module.exports = {
  configureWebpack: {
    module: {
      rules: [
        {
          test: /\.css$/,
          use: [
            'vue-style-loader',
            'css-loader'
          ]
        }
      ]
    }
  }
} 