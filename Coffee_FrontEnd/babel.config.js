module.exports = {
  presets: [
    '@vue/babel-preset-app'
  ],
  plugins: [
    ['@babel/plugin-transform-runtime', {
      'regenerator': true
    }]
  ]
} 