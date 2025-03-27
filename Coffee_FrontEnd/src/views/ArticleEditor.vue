    <template>
  <div class="article-editor">
    <v-container>
      <v-row>
        <v-col cols="12">
          <v-card class="pa-6">
            <v-text-field
              v-model="articleTitle"
              label="文章标题"
              outlined
              dense
              class="mb-4"
            ></v-text-field>
            
            <!-- 编辑器容器 -->
            <div ref="editor" class="editor-container"></div>

            <!-- 操作按钮 -->
            <div class="d-flex justify-end mt-6">
              <v-btn
                text
                color="grey"
                class="mr-4"
                @click="handleCancel"
              >
                取消
              </v-btn>
              <v-btn
                color="primary"
                @click="handleSave"
              >
                保存文章
              </v-btn>
            </div>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import E from 'wangeditor'

export default {
  name: 'ArticleEditor',
  data() {
    return {
      editor: null,
      articleTitle: '',
      articleContent: '<p>请输入文章内容...</p>'
    }
  },
  mounted() {
    this.initEditor()
  },
  beforeDestroy() {
    // 调用销毁方法
    if (this.editor) {
      this.editor.destroy()
    }
  },
  methods: {
    initEditor() {
      // 创建编辑器实例
      this.editor = new E(this.$refs.editor)

      // 配置编辑器
      this.editor.config.height = 500
      this.editor.config.placeholder = '请输入内容...'
      
      // 配置菜单栏
      this.editor.config.menus = [
        'head',
        'bold',
        'fontSize',
        'fontName',
        'italic',
        'underline',
        'strikeThrough',
        'indent',
        'lineHeight',
        'foreColor',
        'backColor',
        'link',
        'list',
        'justify',
        'quote',
        'image',
        'table',
        'code',
        'undo',
        'redo'
      ]

      // 配置图片上传
      this.editor.config.uploadImgShowBase64 = true // 使用 base64 格式
      // 如果有实际的上传接口，可以配置如下：
      /*
      this.editor.config.uploadImgServer = '/api/upload'
      this.editor.config.uploadFileName = 'file'
      */

      // 配置 onchange 回调函数
      this.editor.config.onchange = (html) => {
        this.articleContent = html
      }

      // 创建编辑器
      this.editor.create()

      // 设置初始内容
      this.editor.txt.html(this.articleContent)
    },
    handleSave() {
      const content = this.editor.txt.html()
      console.log('标题:', this.articleTitle)
      console.log('内容:', content)
      
      // TODO: 调用保存接口
    },
    handleCancel() {
      this.$router.go(-1)
    }
  }
}
</script>

<style lang="scss" scoped>
.article-editor {
  padding: 20px 0;
}

.editor-container {
  border: 1px solid #ccc;
  border-radius: 4px;
  margin: 20px 0;
}

:deep(.w-e-text-container) {
  min-height: 500px !important;
  background-color: #fff;
}

:deep(.w-e-toolbar) {
  border-bottom: 1px solid #eee !important;
  background-color: #fafafa !important;
}

:deep(.w-e-text) {
  padding: 20px !important;
}

:deep(.w-e-menu:hover) {
  background-color: #f1f1f1 !important;
  color: #00704A !important;
}

:deep(.w-e-text p) {
  margin: 10px 0;
}
</style> 